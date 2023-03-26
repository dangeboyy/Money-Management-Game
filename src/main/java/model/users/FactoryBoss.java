package model.users;

import lombok.Data;

@Data
public class FactoryBoss extends User {
    private int responsibleFactoryId;

    public FactoryBoss(String userName, String password) {
        super(userName, password);
        controller.Data.factoryBosses.add(this);
    }
}
