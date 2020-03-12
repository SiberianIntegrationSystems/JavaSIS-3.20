package pro.it.sis.javacourse;

public class Target {

    // Максимальное и минимальное кол-во очков здоровья
    private static final int MAX_HEALTH_POINTS = 100;
    private static final int MIN_HEALTH_POINTS = 0;

    // Максимальный и минимальный уровень иммунитета
    private static final double MAX_IMMUNITY = 1;
    private static final double MIN_IMMUNITY = 0;

    private String name;

    // Очки здоровья
    private int physicalHealthPoints;
    private int fireHealthPoints;
    private int iceHealthPoints;

    // Иммунитет для каждого параметра, где
    // 1 - максимальный иммунитет, 0 - минимальный
    // 0 индекс - иммунитет к физ. урону
    // 1 индекс - иммунитет к огню
    // 2 индекс - иммунитет ко льду
    private double[] immunity = new double[3];

    private boolean alive;

    {
        // При создании цель жива, а очки здоровья на максимуме
        physicalHealthPoints = MAX_HEALTH_POINTS;
        fireHealthPoints = MAX_HEALTH_POINTS;
        iceHealthPoints = MAX_HEALTH_POINTS;
        alive = true;
    }

    public Target(String name, double physicalImmunity, double fireImmunity, double iceImmunity) {
        this.name = name;
        setPhysicalImmunity(physicalImmunity);
        setFireImmunity(fireImmunity);
        setIceImmunity(iceImmunity);
    }

    /**
     * Метод, наносящий удар по текущей цели и отнимающий очки здоровья
     * @param damage Наносимый урон
     */
    public void acceptHit(Damage damage) {
        // Если цель уже мертва, то не надо её больше трогать
        if (!isAlive()) return;
        // Если урон больше оставшихся очков жизни, то очки жизни обнуляются
        // Изменение очков здоровья происходит только при отсутствия иммунитета
        physicalHealthPoints = getHealthPointAfterDamage(physicalHealthPoints, damage.getPhysicalDamage(), getPhysicalImmunity());
        fireHealthPoints = getHealthPointAfterDamage(fireHealthPoints, damage.getFireDamage(), getFireImmunity());
        iceHealthPoints = getHealthPointAfterDamage(iceHealthPoints, damage.getIceDamage(), getIceImmunity());
        // Если один из показателей очков здоровья обнулён, то цель погибает
        if (physicalHealthPoints==0 || fireHealthPoints==0 || iceHealthPoints==0)
            alive = false;
    }

    /**
     * Метод, вычислящий оставшиеся очки жизни, после нанесенного урона
     * @param healthPoint Текущие очки здоровья
     * @param damage Наносимый урон по одному из параметров
     * @param immunity Иммунитет по одному из параметров
     * @return Новый уровень очков здоровья
     */
    private int getHealthPointAfterDamage(int healthPoint, int damage, double immunity) {
        // Урон вычисляется по формуле:
        // Очки здоровья - Урон * (1 - Иммунитет), где
        // (1 - Иммунитет) - это процент реально нанесенного урона от общего урона
        // Если урон больше оставшихся очков жизни, то очки жизни обнуляются
        return Math.max( healthPoint - (int)( damage * (1-immunity) ), MIN_HEALTH_POINTS);
    }

    /**
     * Метод вычисляющий действительный иммунитет в соответствии с границами возможного иммунитета
     * @param immunity Предполагаемый иммунитет
     * @return Реальный иммунитет
     */
    private double getRealImmunity(double immunity) {
        if (immunity>MAX_IMMUNITY) {
            // Если предпологаемый иммунитет больше максимума, то иммунитет равен максимуму
            return MAX_IMMUNITY;
        } else {
            // Иначе, если предпологаемый иммунитет больше минимума, то иммунитет равен предполагаемому
            // Иначе иммунитет равен минимуму
            return Math.max(immunity, MIN_IMMUNITY);
        }
    }

    /**
     * Метод возвращает иммунитет к физ. урону
     * @return Иммунитет к физ. урону
     */
    public double getPhysicalImmunity() {
        return immunity[0];
    }

    /**
     * Метод возвращает иммунитет к огню
     * @return Иммунитет к огню
     */
    public double getFireImmunity() {
        return immunity[1];
    }

    /**
     * Метод возвращает иммунитет к холоду
     * @return Иммунитет к холоду
     */
    public double getIceImmunity() {
        return immunity[2];
    }

    /**
     * Метод сохраняет реальное значени иммунитета к физ. урону
     * @param immunity Предполагаемый иммунитет
     */
    public void setPhysicalImmunity(double immunity) {
        this.immunity[0] = getRealImmunity(immunity);
    }

    /**
     * Метод сохраняет реальное значени иммунитета к огню
     * @param immunity Предполагаемый иммунитет
     */
    public void setFireImmunity(double immunity) {
        this.immunity[1] = getRealImmunity(immunity);
    }

    /**
     * Метод сохраняет реальное значени иммунитета ко льду
     * @param immunity Предполагаемый иммунитет
     */
    public void setIceImmunity(double immunity) {
        this.immunity[2] = getRealImmunity(immunity);
    }

    public String getName() {
        return name;
    }

    public int getPhysicalHealthPoints() {
        return physicalHealthPoints;
    }

    public int getFireHealthPoints() {
        return fireHealthPoints;
    }

    public int getIceHealthPoints() {
        return iceHealthPoints;
    }

    public boolean isAlive() {
        return alive;
    }
}
