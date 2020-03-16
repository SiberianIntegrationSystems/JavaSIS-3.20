package interfaces;

/**
 * Интерфейс породистого животного
 * У такого животного есть документы и список наград
 */
public interface Breed {

    /**
     * Награды
     * @return
     */
    String[] getAwards();

    /**
     * Код родословной
     */
    String getPassportCode();

}
