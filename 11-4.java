private static final Logger log = LoggerFactory.getLogger(CoffeeMaker.class);

@Component
@Slf4j
public class LogApplication implements ApplicationRunner {
    @Override
    Public void run(ApplicationArguments args) throws Exception {
        log.trace("application started");
        log.debug("application started");
        log.warn("application started");
        log.error("application started")
    }
}