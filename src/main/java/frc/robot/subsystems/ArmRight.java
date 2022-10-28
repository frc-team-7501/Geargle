package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANMapping;

public class ArmRight extends SubsystemBase {
  private final CANSparkMax rightArmMotor = new CANSparkMax(CANMapping.SPARKMAX_RIGHTARM, MotorType.kBrushless);

  private static ArmRight instance;
  public static ArmRight getInstance() {
    if (instance == null)
      instance = new ArmRight();
    return instance;
  }

  private ArmRight() {
    // Configure arm motors

    rightArmMotor.restoreFactoryDefaults();
    rightArmMotor.setIdleMode(IdleMode.kBrake);

    rightArmMotor.setSmartCurrentLimit(30); // TODO: tune this if needed
  }
  
  public void manualControl(double rightPower) {
    if (Math.abs(rightPower) < 0.01)  rightPower = 0;
      rightArmMotor.set(rightPower * -.2);
  }
}
