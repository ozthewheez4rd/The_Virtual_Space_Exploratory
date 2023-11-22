// CargoInfoAdapter class adapting Cargo to CargoInfo
public class CargoInfoAdapter implements CargoInfo {
    private Cargo cargo;

    public CargoInfoAdapter(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String getDescription() {
        return cargo.getName();  // Adapt Cargo's name to CargoInfo's description
    }
}