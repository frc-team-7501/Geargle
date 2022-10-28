package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANMapping;

public class ArmLeft extends SubsystemBase {
  private final CANSparkMax leftArmMotor = new CANSparkMax(CANMapping.SPARKMAX_LEFTARM, MotorType.kBrushless);

  private static ArmLeft instance;
  public static ArmLeft getInstance() {
    if (instance == null)
      instance = new ArmLeft();
    return instance;
  }

  private ArmLeft() {
    // Configure arm motors

    leftArmMotor.restoreFactoryDefaults();
    leftArmMotor.setIdleMode(IdleMode.kBrake);

    leftArmMotor.setSmartCurrentLimit(30); // TODO: tune this if needed
  }

  public void manualControl(double leftPower) {
    
  if (Math.abs(leftPower) < 0.01) leftPower = 0;
    leftArmMotor.set(leftPower *.2);
  } 
}
