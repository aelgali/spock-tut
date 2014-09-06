package net.elgali.bank.service

import net.elgali.bank.model.Account
import spock.lang.Specification


/**
 * Created by aelgali on 9/6/14.
 */
class AccountServiceSpec extends Specification {
    def accountService
    def accountA
    def accountB

    def setup() {
        accountService = new AccountServiceImpl()

        accountA = new Account()
        accountA.id = 1
        accountA.ownerName = "Owner 1"
        accountA.number = "ABC11111111111"

        accountB = new Account()
        accountB.id = 2
        accountB.ownerName = "Owner 2"
        accountB.number = "ABC22222222222"

    }
    def "Transfer Balance Between accounts" () {
        given:
        accountA.balance = 100.00
        accountB.balance = 150.00

        when:
        accountService.transferBalance(accountA, accountB, 50)

        then:
        accountA.balance == 50.00
        accountB.balance == 200.00
    }

}