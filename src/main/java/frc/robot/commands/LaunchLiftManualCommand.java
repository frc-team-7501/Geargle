// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.LaunchLift;

public class LaunchLiftManualCommand extends Command {
   private final LaunchLift launchLift;
   private final DoubleSupplier supplierLiftUp;
   private final DoubleSupplier supplierLiftDown;
   
  /** Creates a new LaunchLiftManualCommand. */
  
  public LaunchLiftManualCommand(final LaunchLift launchLift, final DoubleSupplier supplierLiftUp, final DoubleSupplier supplierLiftDown) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.launchLift = launchLift;
    this.supplierLiftUp = supplierLiftUp;
    this.supplierLiftDown = supplierLiftDown;
    addRequirements(launchLift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double inputLaunchLift;
    Double liftUp = supplierLiftUp.getAsDouble();
    Double liftDown = supplierLiftDown.getAsDouble();
    if ((liftDown < 0.05 && liftUp < 0.05) || (liftDown > 0.05 && liftUp > 0.05)) {
        inputLaunchLift = 0;
    }
    else if (liftDown > 0.05) {
        inputLaunchLift = liftDown *-1;
    }
    else if (liftUp > 0.05) {
        inputLaunchLift = liftUp;
    }
    else {
        inputLaunchLift = 0;
    }     
    launchLift.manualControl(inputLaunchLift);
    SmartDashboard.putNumber("liftUp",liftUp);
    SmartDashboard.putNumber("liftDown",liftDown);
    SmartDashboard.putNumber("launchLift",inputLaunchLift);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    launchLift.manualControl(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
