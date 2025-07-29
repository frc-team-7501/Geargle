package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Eyebrows;

public class EyebrowManualCommand extends Command {
  private final Eyebrows eyebrows;
  private double leftPosition;
  private double rightPosition;
 
  public EyebrowManualCommand(final Eyebrows eyebrows, double leftPosition, double rightPosition) {
    this.eyebrows = eyebrows;
    this.leftPosition = leftPosition;
    this.rightPosition = rightPosition;
    addRequirements(eyebrows);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    eyebrows.servoControl(leftPosition, rightPosition);
  }

  @Override
  public void end(boolean interrupted) {
    eyebrows.servoControl(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
