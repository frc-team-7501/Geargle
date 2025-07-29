package frc.robot.commands;

import java.util.function.DoubleSupplier;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.ArmLeft;

public class ArmLeftManualCommand extends Command {
  private final ArmLeft armLeft;
  private final DoubleSupplier supplierL;
 
  public ArmLeftManualCommand(final ArmLeft armLeft, final DoubleSupplier supplierL) {
    this.armLeft = armLeft;
    this.supplierL = supplierL;
    
    addRequirements(armLeft);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double inputL = supplierL.getAsDouble();
    armLeft.manualControl(inputL);
  }

  @Override
  public void end(boolean interrupted) {
    armLeft.manualControl(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
