// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticsMapping;
import frc.robot.Constants.CANMapping;

public class LaunchCharge extends SubsystemBase {
    private final Solenoid chargeSolenoid = new Solenoid(CANMapping.PNEUMATIC_HUB, PneumaticsModuleType.CTREPCM,
            PneumaticsMapping.PNEUMATIC_CHARGE);
            
    private static LaunchCharge instance;

    public static LaunchCharge getInstance() {
        if (instance == null)
          instance = new LaunchCharge();
        return instance;
    }

    public LaunchCharge() {
    }

    public void LaunchChargeCommand(boolean OpenClose) {
        chargeSolenoid.set(OpenClose);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
