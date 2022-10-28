package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmRight;

public class ArmRightManualCommand extends CommandBase {
  private final ArmRight armRight;
  private final DoubleSupplier supplierR;
 
  public ArmRightManualCommand(final ArmRight armRight, final DoubleSupplier supplierR) {
    this.armRight = armRight;
    this.supplierR = supplierR;
    addRequirements(armRight);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double inputR = supplierR.getAsDouble();
    armRight.manualControl(inputR);
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
