package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ControllerMapping;
import frc.robot.commands.DriveManualCommand;
import frc.robot.commands.ArmRightManualCommand;
import frc.robot.commands.ArmLeftManualCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ArmRight;
import frc.robot.subsystems.ArmLeft;
import frc.robot.utils.ExtendedJoystick;
import frc.robot.utils.ExtendedXboxController;
import frc.robot.utils.InputNormalizer;

public class RobotContainer {
  private final ExtendedJoystick stick = new ExtendedJoystick(ControllerMapping.JOYSTICK);
  private final ExtendedXboxController controller = new ExtendedXboxController(ControllerMapping.XBOX);

  private final DriveTrain driveTrain = DriveTrain.getInstance();
  private final ArmRight armRight = ArmRight.getInstance();
  private final ArmLeft armLeft = ArmLeft.getInstance();


  private final Command driveManualCommand = new DriveManualCommand(
    driveTrain,
    () -> stick.getY() * (stick.getThrottle() * 0.5 + 0.5), () -> -stick.getX(),
    () -> stick.getTop()
  );

  private final Command ArmRightManualCommand = new ArmRightManualCommand(armRight, () -> InputNormalizer.calculate(controller.getRightY(), 0.05, -1, 1));
  private final Command ArmLeftManualCommand = new ArmLeftManualCommand(armLeft, () -> InputNormalizer.calculate(controller.getLeftY(), 0.05, -1, 1));


  public RobotContainer() {

    configureButtonBindings();

    driveTrain.setDefaultCommand(driveManualCommand);
    armRight.setDefaultCommand(ArmRightManualCommand);
    armLeft.setDefaultCommand(ArmLeftManualCommand);

    ShuffleboardTab subsysTab = Shuffleboard.getTab("Subsystems");
    subsysTab.add("DriveTrain", driveTrain);
    subsysTab.add("ArmRight", armRight);
    subsysTab.add("ArmLeft", armLeft);


  }

  // Lifecycle hooks

  public void autonomousInit() {
    driveTrain.setBrakeMode(true);
  }

  public void teleopInit() {
    driveTrain.setBrakeMode(false);
  }

  private void configureButtonBindings() {

  }
}
