package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы с возможностью:
 * регистрировать/удалять клиента, добавлять клиенту банковский
 * счет(у клиента может быть несколько счетов), переводить деньги
 * с одного счета на другой.
 * @author Bronislav Shestakov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех клиентов и их счетов осуществляется в коллекции
     * HashMap, где ключом является "клиент", которые дает доступ к его счетам.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавления нового клиента в список клиентов банка.
     * Клиент будет добавлен если его еще нет в списке клиентов - метод putIfAbsent.
     * При добавлении у клиента создается пустой список счетов.
     * @param user клиент банка.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавления счета клиенту.
     * Счет будет добавлен если: клиент есть в списке клиентов; реквизиты счета отсутствуют
     * в списке счетов данного клиента.
     * @param passport серия и номер паспорта, для работы метода:
     * @see #findByPassport(String passport)
     * @param account счет который будет добавлен в список счетов клиента.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод поиска клиента по серии и номеру паспорта.
     * Поиск осуществляется перебором всех клиентов коллецкии, сравнивая
     * их значения серии и номера паспорта.
     * @param passport серия и номер паспорта.
     * @return найденный клиент. Если пользователь не найден - null.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод поиска банковского счета по серии и номеру паспорта и номеру
     * банковского счета.
     * Если клиент найден по серии и номеру паспорта, осуществляется
     * поиск баковского счета в списке его счетов.
     * @param passport серия и номер паспорта, для работы метода:
     * @see #findByPassport(String passport)
     * @param requisite номер банковского счета.
     * @return банковский счет. Если счет не найден - null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод перевода денежных средств с одного счета на другой. В реализации участвует:
     * @see #findByRequisite(String, String) - для поиска счетов.
     * Перевод будет осуществлен если найдены счет списания и счет назначения, а так же баланс
     * счета списания больше либо равен сумме перевода.
     * @param srcPassport серия и номер паспорта клиента-отправителя перевода.
     * @param srcRequisite номер счета клиента-отправителя.
     * @param destPassport серия и номер паспорта клиента-получателя перевода.
     * @param destRequisite номер счета клиента-получателя.
     * @param amount сумма перевода.
     * @return true - если перевод осуществлен, иначе false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
