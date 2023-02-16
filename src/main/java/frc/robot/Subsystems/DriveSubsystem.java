package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    
    //Left Main, Left Follower, Right Main, Right Follower
    private final CANSparkMax leftMain = new CANSparkMax( 0, MotorType.kBrushed); 
    private final CANSparkMax leftFollower = new CANSparkMax( 0, MotorType.kBrushless); 
    private final CANSparkMax rightMain = new CANSparkMax( 0, MotorType.kBrushless); 
    private final CANSparkMax rightFollower = new CANSparkMax( 0, MotorType.kBrushless); 

    private DifferentialDrive drive; 

    public DriveSubsystem() {
        leftMain.restoreFactoryDefaults(); 
        leftFollower.restoreFactoryDefaults(); 
        rightMain.restoreFactoryDefaults(); 
        rightFollower.restoreFactoryDefaults(); 

        leftMain.setIdleMode(IdleMode.kBrake); 
        leftFollower.setIdleMode(IdleMode.kBrake); 
        rightMain.setIdleMode(IdleMode.kBrake);
        rightFollower.setIdleMode(IdleMode.kBrake); 

        rightMain.setInverted(true);

        leftFollower.follow(leftMain); 
        rightFollower.follow(rightMain);


    }

    public void arcadeDrive(double forwardSpeed, double rotationSpeed) {
        drive.arcadeDrive(forwardSpeed, rotationSpeed);
    }
}
