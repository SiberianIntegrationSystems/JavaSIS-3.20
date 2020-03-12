package pro.it.sis.javacourse;

/**
 * Класс представляющий собой значения наносимого урона
 */
public class Damage {
    // Максимальный урон
    private static final int MAX_DAMAGE = 100;
    // Минимальный урон
    private static final int MIN_DAMAGE = 0;

    // Значения урона
    private int physicalDamage;
    private int fireDamage;
    private int iceDamage;

    public Damage(int physicalDamage, int fireDamage, int iceDamage) {
        // Получение и запись урона, соответствующего границам
        this.physicalDamage = getRealDamage(physicalDamage);
        this.fireDamage = getRealDamage(fireDamage);
        this.iceDamage = getRealDamage(iceDamage);
    }

    /**
     * Метод вычисляющий действительный урон в соответствии с границами возможного урона
     * @param damage Предлагающийся урон
     * @return Действительный урон
     */
    private int getRealDamage(int damage) {
        if (damage>MAX_DAMAGE) {
            // Если предпологаемый урон больше максимума, то урон равен максимуму
            return MAX_DAMAGE;
        } else {
            // Иначе, если предпологаемый урон больше минимума, то урон равен предполагаемому
            // Иначе урон равен минимуму
            return Math.max(damage, MIN_DAMAGE);
        }

    }

    public void setPhysicalDamage(int physicalDamage) {
        // Получение и запись урона, соответствующего границам
        this.physicalDamage = getRealDamage(physicalDamage);
    }

    public void setFireDamage(int fireDamage) {
        // Получение и запись урона, соответствующего границам
        this.fireDamage = getRealDamage(fireDamage);
    }

    public void setIceDamage(int iceDamage) {
        // Получение и запись урона, соответствующего границам
        this.iceDamage = getRealDamage(iceDamage);
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public int getFireDamage() {
        return fireDamage;
    }

    public int getIceDamage() {
        return iceDamage;
    }
}
