package Chatbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


/**
 *
 * @author roilanrodriguez55
 */
public class Bot extends TelegramLongPollingBot{

    @Override
    public void onUpdateReceived(Update update) {
        String mensaje=update.getMessage().getText();
        Long ChatId=update.getMessage().getChatId();
        if (menu(mensaje)!=null) {
            enviarMensaje(generarMensaje(ChatId, menu(mensaje)));
        }else {
            enviarMensaje(generarMensaje(ChatId, "No  coincide el comando"));
        }
    }

    @Override
    public String getBotUsername() {
        return "@roilanrodriguez55_bot";
    }
    
    @Override
    public String getBotToken(){
        return "6280317322:AAGusHq00UdP2KNB_t5h-pIJ3pshwLtgRKg";
    }
    
    public SendMessage generarMensaje(Long ChatId, String msj){
        return new SendMessage(ChatId.toString(), msj);
    }
    
    public void enviarMensaje(SendMessage sm){
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
    public String menu(String opcion){
        return switch (opcion) {
            case "/menu" -> "/menu";
            case "/edad" -> "21";
            case "/nombre" -> "Roilan Rodriguez Castillo";
            case "/fecha" -> "2002/03/02";
            case "/madre"->"Kisvel";
            case "/padre"->"Rolando";
            case "/carrera"->"Ingenieria informatica";
            case "/facebook"->"https://www.facebook.com/roilan.rodriguez.779/";
            case "/twitter"->"https://twitter.com/RoilanRod";
            default -> null;
        };
    }
    

    
    
    
    
}
