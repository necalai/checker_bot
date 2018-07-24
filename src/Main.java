import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.telegram.abilitybots.api.db.MapDBContext;
import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class Main {
    private static String BOT_NAME = Config.BOT_USERNAME;
    private static String BOT_TOKEN = Config.BOT_TOKEN;

    private static String PROXY_HOST = "35.203.128.140" /* proxy host */;
    private static Integer PROXY_PORT = 1080 /* proxy port */;
    private static String PROXY_USER = "necalai" /* proxy user */;
    private static String PROXY_PASSWORD = "threefriends" /* proxy password */;



    public static void main(String[] args) {


            ApiContextInitializer.init();

            // Create the TelegramBotsApi object to register your bots
            TelegramBotsApi botsApi = new TelegramBotsApi();

              System.getProperties().put( "proxySet", "true" );
        System.getProperties().put( "socksProxyHost", "35.203.128.140" );
        System.getProperties().put( "socksProxyPort", "1080" );

        Authenticator.setDefault(new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("necalai", "threefriends".toCharArray());
            }
        });


            // Set up Http proxy
//            DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
//
//            CredentialsProvider credsProvider = new BasicCredentialsProvider();
//            credsProvider.setCredentials(
//                    new AuthScope(PROXY_HOST, PROXY_PORT),
//                    new UsernamePasswordCredentials(PROXY_USER, PROXY_PASSWORD));
//
//            HttpHost httpHost = new HttpHost(PROXY_HOST, PROXY_PORT);
//
//            RequestConfig requestConfig = RequestConfig.custom().setProxy(httpHost).setAuthenticationEnabled(true).build();
//            botOptions.setRequestConfig(requestConfig);
//            botOptions.setCredentialsProvider(credsProvider);
//            botOptions.setHttpProxy(httpHost);

            // Register your newly created AbilityBot
            MyBot bot = new MyBot(BOT_TOKEN, BOT_NAME, new MapDBContext(null));

        try {

            botsApi.registerBot(bot);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
