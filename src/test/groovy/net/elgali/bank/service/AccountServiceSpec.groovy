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

    def "Transfer #amount between accounts #accountABalance #accountBBalance" () {
        given:
        accountA.balance = accountABalance
        accountB.balance = accountBBalance

        when:
        accountService.transferBalance(accountA, accountB, amount)

        then:
        accountA.balance == accountABalanceResult
        accountB.balance == accountBBalanceResult

        where:
        amount  |   accountABalance |   accountBBalance ||   accountABalanceResult   |   accountBBalanceResult
        50      |   100.00          |   150.00          ||   50.00                   |   200.00
        100     |   100.00          |   150.00          ||   0.00                    |   250.00

    }

    def "Transfer negative #amount between #accountABalance to #accountBBalance"() {
        given:
        accountA.balance = accountABalance
        accountB.balance = accountBBalance

        when:
        accountService.transferBalance(accountA, accountB, amount)

        then:
        accountA.balance == accountABalanceResult
        accountB.balance == accountBBalanceResult
        thrown(InsufficientFundException)

        where:
        amount  |   accountABalance |   accountBBalance ||   accountABalanceResult   |   accountBBalanceResult
        -50      |   100.00          |   150.00          ||   100.00                   |   150.00

    }

}