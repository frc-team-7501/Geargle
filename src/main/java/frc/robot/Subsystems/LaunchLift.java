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

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANMapping;

public class LaunchLift extends SubsystemBase {
    private final SparkMax launchLiftMotor;
    private SparkMaxConfig launchLiftMotorConfig;

    private static LaunchLift instance;

    public static LaunchLift getInstance() {
        if (instance == null)
            instance = new LaunchLift();
        return instance;
    }

    /** Creates a new LaunchLift. */
    public LaunchLift() {
        launchLiftMotor = new SparkMax(CANMapping.SPARKMAX_LAUNCHLIFT, MotorType.kBrushless);
        launchLiftMotorConfig = new SparkMaxConfig();
        // Configure lift motor
        launchLiftMotorConfig.idleMode(IdleMode.kBrake);
        launchLiftMotorConfig.smartCurrentLimit(30);
        launchLiftMotor.configure(launchLiftMotorConfig, ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
    }

    public void manualControl(double power) {
        if (Math.abs(power) < 0.01)
           power = 0;
        launchLiftMotor.set(power);
    }
}
