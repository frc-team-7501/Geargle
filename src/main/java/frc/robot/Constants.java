package frc.robot;

public final class Constants {
    public static final class CANMapping {

        // DriveTrain
        public static final int VICTORSPX_DRIVE_BL = 3;
        public static final int VICTORSPX_DRIVE_BR = 1;
        public static final int VICTORSPX_DRIVE_FL = 4;
        public static final int VICTORSPX_DRIVE_FR = 2;

        // Arms
        public static final int SPARKMAX_RIGHTARM = 41;
        public static final int SPARKMAX_LEFTARM = 40;


        // MISC CAN Bus
        public static final int PNEUMATIC_HUB = 0;
        public static final int SPARKMAX_LAUNCHLIFT = 42;
    }
        // Pneumatics Control Module
    public static final class PneumaticsMapping {
        public static final int PNEUMATIC_LAUNCH = 1;
        public static final int PNEUMATIC_CHARGE = 2;
        
    }

    public static final class ControllerMapping {
        public static final int JOYSTICK = 0;
        public static final int XBOX = 1;
    }

    public static final class MiscMapping {
        // Eyebrows
        public static final int SERVO_LEFTEYEBROW = 0;
        public static final int SERVO_RIGHTEYEBROW = 1;
    }
}
