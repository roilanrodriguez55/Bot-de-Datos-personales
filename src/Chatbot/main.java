
package Chatbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 *
 * @author roilanrodriguez55
 */
public class main {
    public static void main(String[] args) {
        
        try {
            TelegramBotsApi bot=new TelegramBotsApi(DefaultBotSession.class);
            bot.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        
        
    }
    
    
}
