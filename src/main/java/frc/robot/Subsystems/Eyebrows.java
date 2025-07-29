// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MiscMapping;

public class Eyebrows extends SubsystemBase {
    /** Creates a new Eyebrows. */

    Servo eyebrowLeft = new Servo(MiscMapping.SERVO_LEFTEYEBROW);
    Servo eyebrowRight = new Servo(MiscMapping.SERVO_RIGHTEYEBROW);

    private static Eyebrows instance;

    public static Eyebrows getInstance() {
        if (instance == null)
            instance = new Eyebrows();
        return instance;
    }

    public Eyebrows() {
        servoControl(.5, .5);
    }

    public void servoControl(double leftPosition, double rightPosition) {
        eyebrowLeft.set(leftPosition);
        eyebrowRight.set(rightPosition);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
