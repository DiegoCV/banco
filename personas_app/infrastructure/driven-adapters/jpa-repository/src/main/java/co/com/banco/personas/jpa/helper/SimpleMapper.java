package co.com.banco.personas.jpa.helper;

public interface SimpleMapper<E, D> {
    D toData(E entity);
    E toEntity(D data);
}