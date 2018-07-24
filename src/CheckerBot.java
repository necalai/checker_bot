import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import sun.net.SocksProxy;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;

public class CheckerBot extends TelegramLongPollingBot {

    public CheckerBot() {
    }

    public CheckerBot(DefaultBotOptions options) {
        super(options);
    }

    public static void main(String[] args) {
        Config.load();

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

//      System.getProperties().put( "proxySet", "true" );
//        System.getProperties().put( "socksProxyHost", "35.203.128.140" );
//        System.getProperties().put( "socksProxyPort", "1080" );
//
//        Authenticator.setDefault(new Authenticator(){
//            protected PasswordAuthentication getPasswordAuthentication(){
//                return new PasswordAuthentication("necalai", "threefriends".toCharArray());
//            }
//        });

//        DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
//
//        CredentialsProvider credsProvider = new BasicCredentialsProvider();
//        credsProvider.setCredentials(
//                new AuthScope(new HttpHost("35.203.128.140", 1080)),
//                new UsernamePasswordCredentials("necalai", "threefriends"));
//
//        HttpHost httpHost = new HttpHost(new HttpHost("35.203.128.140", 1080));
//
//        RequestConfig requestConfig = RequestConfig.custom().setProxy(httpHost).setAuthenticationEnabled(true).build();
//        botOptions.setRequestConfig(requestConfig);
//        botOptions.setCredentialsProvider(credsProvider);
//        botOptions.setHttpProxy(httpHost);

//        // Set up Http proxy
//        DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
//
//        CredentialsProvider credsProvider = new BasicCredentialsProvider();
//        credsProvider.setCredentials(
//                new AuthScope("35.203.128.140", 1080),
//                new UsernamePasswordCredentials("necalai", "threefriends"));
//
//        HttpHost httpHost = new HttpHost("35.203.128.140", 1080);
//
//        RequestConfig requestConfig = RequestConfig.custom().setProxy(httpHost).setAuthenticationEnabled(true).build();
//        botOptions.setRequestConfig(requestConfig);
//        botOptions.setCredentialsProvider(credsProvider);
//        botOptions.setHttpProxy(httpHost);


        CheckerBot bot = new CheckerBot();

        try {
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
    }

    @Override
    public String getBotUsername() {
        return Config.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return Config.BOT_TOKEN;
    }
}
