package service.impl;

import exceptions.DatabaseNullException;
import exceptions.EntryLimitException;
import exceptions.LackOfFundsException;
import exceptions.NotNullException;
import service.CardService;
import service.CustomerService;
import service.ManagementService;

import static util.MenuUtil.*;

public class IManagementService implements ManagementService {
    @Override
    public void managementService() {
        CustomerService customerService = new ICustomerService();
        CardService cardService = new ICardService();
        while (true) {
            try {
                byte option = mainMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        customerService.Register();
                        break;
                    case 2:
                        boolean range = true;
                        try {
                            customerService.Login();
                        } catch (EntryLimitException ex) {
                            System.out.println("Login limit exceeded!");
                            break;
                        }
                        while (range) {

                            byte loginOption = loginMenu();
                            switch (loginOption) {
                                case 1:
                                    customerService.ShowDetails();
                                    break;
                                case 2:
                                    customerService.Update();
                                    break;
                                case 3:
                                    byte operationMenu = operationsMenu();
                                    switch (operationMenu) {
                                        case 1:
                                            cardService.ShowBalance();
                                            break;
                                        case 2:
                                            cardService.CashingOut();
                                            break;
                                        default:
                                            System.out.println("Wrong option!");
                                    }
                                    break;
                                case 4:
                                    range = false;
                                    break;
                            }

                        }
                        break;
                    case 3:
                        cardService.IncreaseTheBalance();
                    default:
                        System.out.println("Wrong option!");
                }
            } catch (DatabaseNullException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}
