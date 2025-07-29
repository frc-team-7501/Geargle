package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.ArmRight;

public class ArmRightButtonCommand extends Command {
  private final ArmRight armRight;
  private final double rightSpeed;
 
  public ArmRightButtonCommand(final ArmRight armRight, final double rightSpeed) {
    this.armRight = armRight;
    this.rightSpeed = rightSpeed;
    addRequirements(armRight);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    armRight.manualControl(rightSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    armRight.manualControl(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
