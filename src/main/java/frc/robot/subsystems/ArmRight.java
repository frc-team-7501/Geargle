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

public class ArmRight extends SubsystemBase {
  private final SparkMax rightArmMotor;
  private SparkMaxConfig rightArmMotorConfig;

  private static ArmRight instance;

  public static ArmRight getInstance() {
    if (instance == null)
      instance = new ArmRight();
    return instance;
  }

  private ArmRight() {
    rightArmMotor = new SparkMax(CANMapping.SPARKMAX_RIGHTARM, MotorType.kBrushless);
    rightArmMotorConfig = new SparkMaxConfig();
    // Configure arm motors
    rightArmMotorConfig.idleMode(IdleMode.kBrake);
    rightArmMotorConfig.smartCurrentLimit(30);
    rightArmMotor.configure(rightArmMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void manualControl(double rightPower) {
    SmartDashboard.putNumber("right arm", rightPower);
    if (Math.abs(rightPower) < 0.01)
        rightPower = 0;
    rightArmMotor.set(rightPower * .2);
  } 
}
