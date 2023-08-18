package service.impl;

public interface ICountMoney<T> {
    double income(T t);
    double vat(T t);

}
