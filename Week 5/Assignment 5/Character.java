
abstract class Character {
    protected WeaponBehavior weapon;
    protected abstract void fight();
    
}


class King extends Character{
    King() {}
    public void fight() {
        System.out.println("King fights with weapon " + weapon.useWeapon());
    }
}

class Knight extends Character{
    Knight() {}
    public void fight() {
        System.out.println("Knight fights with weapon " + weapon.useWeapon());
    }
}

class Queen extends Character{
    Queen() {}
    public void fight() {
        System.out.println("Queen fights with weapon " + weapon.useWeapon());
    }
}

class Troll extends Character{
    Troll() {}
    public void fight() {
        System.out.println("Troll fights with weapon " + weapon.useWeapon());
    }
}

abstract class WeaponBehavior {
    protected abstract String useWeapon();
}

class Knife extends WeaponBehavior {
    Knife() {}
    public String useWeapon() {
        return "Knife";
    }
}

class Axe extends WeaponBehavior {
    Axe() {}
    public String useWeapon() {
        return "Axe";
    }
}

class Sword extends WeaponBehavior {
    Sword() {}
    public String useWeapon() {
        return "Sword";
    }
}

class Club extends WeaponBehavior {
    Club() {}
    public String useWeapon() {
        return "Club";
    }
}