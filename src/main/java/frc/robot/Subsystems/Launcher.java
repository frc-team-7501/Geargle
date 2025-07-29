// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticsMapping;
import frc.robot.Constants.CANMapping;

public class Launcher extends SubsystemBase {
    private final Solenoid launchSolenoid = new Solenoid(CANMapping.PNEUMATIC_HUB, PneumaticsModuleType.CTREPCM,
            PneumaticsMapping.PNEUMATIC_LAUNCH);
            
    private static Launcher instance;

    public static Launcher getInstance() {
        if (instance == null)
          instance = new Launcher();
        return instance;
    }

    public Launcher() {
    }

    public void LaucherCommand(boolean OpenClose) {
        launchSolenoid.set(OpenClose);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
