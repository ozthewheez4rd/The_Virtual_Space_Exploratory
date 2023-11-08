import java.io.Serializable;

public class Body implements Serializable {
//    private static final long serialVersionUID = -7509304743105491105L;

    private String torso;
    private String head;
    private String leftArm;
    private String rightArm;
    private String leftLeg;
    private String rightLeg;

    public Body() {
        // Initialize the body parts with default values
        this.torso = "Healthy";
        this.head = "Healthy";
        this.leftArm = "Healthy";
        this.rightArm = "Healthy";
        this.leftLeg = "Healthy";
        this.rightLeg = "Healthy";
    }

    public boolean isHealthy() {
        return "Healthy".equals(torso) && "Healthy".equals(head) && "Healthy".equals(leftArm) &&
                "Healthy".equals(rightArm) && "Healthy".equals(leftLeg) && "Healthy".equals(rightLeg);
    }

    public String getTorso() {
        return torso;
    }

    public void setTorso(String torso) {
        this.torso = torso;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getLeftArm() {
        return leftArm;
    }

    public void setLeftArm(String leftArm) {
        this.leftArm = leftArm;
    }

    public String getRightArm() {
        return rightArm;
    }

    public void setRightArm(String rightArm) {
        this.rightArm = rightArm;
    }

    public String getLeftLeg() {
        return leftLeg;
    }

    public void setLeftLeg(String leftLeg) {
        this.leftLeg = leftLeg;
    }

    public String getRightLeg() {
        return rightLeg;
    }

    public void setRightLeg(String rightLeg) {
        this.rightLeg = rightLeg;
    }
}