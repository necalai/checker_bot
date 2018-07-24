import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class MyBot extends AbilityBot {

    public MyBot(String botToken, String botUsername, DefaultBotOptions botOptions) {
        super(botToken, botUsername, botOptions);
    }

    public MyBot(String botToken, String botUsername, DBContext db, DefaultBotOptions botOptions) {
        super(botToken, botUsername, db, botOptions);
    }

    public MyBot(String botToken, String botUsername) {
        super(botToken, botUsername);
    }

    public MyBot(String botToken, String botUsername, DBContext db) {
        super(botToken, botUsername, db);
    }

    @Override
    public int creatorId() {
        return 0;
    }

    public Ability hello() {
        return Ability.builder()
                .name("test")
                .info("hello bot")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> silent.send("hello!", ctx.chatId()))
                .build();
    }
}
