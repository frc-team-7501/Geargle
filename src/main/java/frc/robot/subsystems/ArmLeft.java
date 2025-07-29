// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANMapping;

public class ArmLeft extends SubsystemBase {
  private final SparkMax leftArmMotor;
  private SparkMaxConfig leftArmMotorConfig;

  private static ArmLeft instance;

  public static ArmLeft getInstance() {
    if (instance == null)
      instance = new ArmLeft();
    return instance;
  }

  private ArmLeft() {
    leftArmMotor = new SparkMax(CANMapping.SPARKMAX_LEFTARM, MotorType.kBrushless);
    leftArmMotorConfig = new SparkMaxConfig();
    // Configure arm motors
    leftArmMotorConfig.idleMode(IdleMode.kBrake);
    leftArmMotorConfig.smartCurrentLimit(30);
    leftArmMotor.configure(leftArmMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void manualControl(double leftPower) {
    SmartDashboard.putNumber("left arm", leftPower);
    if (Math.abs(leftPower) < 0.01)
      leftPower = 0;
    leftArmMotor.set(leftPower * .2);
  } 
}
