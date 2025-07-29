package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.ControllerMapping;
import frc.robot.Subsystems.ArmLeft;
import frc.robot.Subsystems.ArmRight;
import frc.robot.Subsystems.DriveTrain;
import frc.robot.Subsystems.Eyebrows;
import frc.robot.Subsystems.LaunchCharge;
import frc.robot.Subsystems.LaunchLift;
import frc.robot.Subsystems.Launcher;
import frc.robot.commands.*;
import frc.robot.utils.ExtendedJoystick;
import frc.robot.utils.ExtendedXboxController;
import frc.robot.utils.InputNormalizer;

public class RobotContainer {
    private final ExtendedJoystick stick = new ExtendedJoystick(ControllerMapping.JOYSTICK);
    private final ExtendedXboxController controller = new ExtendedXboxController(ControllerMapping.XBOX);

    private final DriveTrain driveTrain = DriveTrain.getInstance();
    private final ArmRight armRight = ArmRight.getInstance();
    private final ArmLeft armLeft = ArmLeft.getInstance();
    private final Eyebrows eyebrows = Eyebrows.getInstance();
    private final Launcher launcher = Launcher.getInstance();
    private final LaunchLift launchLift = LaunchLift.getInstance();
    private final LaunchCharge launchCharge = LaunchCharge.getInstance();

    private final Command driveManualCommand = new DriveManualCommand(
            driveTrain,
            () -> stick.getY() * (stick.getThrottle() * 0.5 + 0.5), () -> -stick.getX(),
            () -> stick.getTop());

    private final Command ArmRightManualCommand = new ArmRightManualCommand(armRight,
            () -> controller.getRightY());
    private final Command ArmLeftManualCommand = new ArmLeftManualCommand(armLeft,
            () -> controller.getLeftY());
            
    private final Command LaunchLiftManualCommand = new LaunchLiftManualCommand(launchLift,
            () -> controller.getLeftTriggerAxis(),
            () -> controller.getRightTriggerAxis());

    public RobotContainer() {

        configureButtonBindings();

        driveTrain.setDefaultCommand(driveManualCommand);
        armRight.setDefaultCommand(ArmRightManualCommand);
        armLeft.setDefaultCommand(ArmLeftManualCommand);
        launchLift.setDefaultCommand(LaunchLiftManualCommand);

        ShuffleboardTab subsysTab = Shuffleboard.getTab("Subsystems");
        subsysTab.add("DriveTrain", driveTrain);
        subsysTab.add("ArmRight", armRight);
        subsysTab.add("ArmLeft", armLeft);
    }

    // Lifecycle hooks

    public void autonomousInit() {
        driveTrain.setBrakeMode(true);
        armRight.resetEncoder();
    }

    public void teleopInit() {
        driveTrain.setBrakeMode(false);
        armRight.resetEncoder();
    }

    private void configureButtonBindings() {
        // angry
        controller.b_B().onTrue(new EyebrowManualCommand(eyebrows, .4, .6));
        // happy
        controller.b_A().onTrue(new EyebrowManualCommand(eyebrows, .6, .4));
        // surprised
        controller.b_Y().onTrue(new EyebrowManualCommand(eyebrows, .6, .3));
        // chill
        controller.b_X().onTrue(new EyebrowManualCommand(eyebrows, .5, .5));

        stick.b_Trigger().onTrue(
                new SequentialCommandGroup(
                        new LauncherOpen(launcher),
                        new WaitCommand(1),
                        new LauncherClose(launcher)));
     
        stick.b_BottomBL().onTrue(
                new SequentialCommandGroup(
                        new LaunchBeginCharge(launchCharge),
                        new WaitCommand(4),
                        new LaunchStopCharge(launchCharge)));
    }
}
