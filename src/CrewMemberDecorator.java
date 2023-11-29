public class CrewMemberDecorator {
    private CrewMember crewMember;
    private String helmet;
    private String shield;

    public CrewMemberDecorator(CrewMember crewMember, String helmet, String shield) {
        this.crewMember = crewMember;
        this.helmet = helmet;
        this.shield = shield;
    }

    public String getName() {
        return crewMember.getName();
    }

    public String getPosition() {
        return crewMember.getPosition();
    }

    public String getStatus() {
        return crewMember.getStatus();
    }

    public String getTreatmentMessage() {
        return crewMember.getTreatmentMessage();
    }

    public Body getBody() {
        return crewMember.getBody();
    }

    public void explore() {
        crewMember.explore();
    }

    // Custom methods for equipment details
    public String getHelmet() {
        return helmet;
    }

    public String getShield() {
        return shield;
    }

    public void additionalFunctionality() {
        // Add equipment-related functionality
        System.out.println(getName() + " is equipped with special gear.");
        System.out.println("Helmet: " + getHelmet());
        System.out.println("Shield: " + getShield());
    }
}