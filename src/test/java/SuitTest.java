import br.edu.utfpr.tsi.atividadejpa.repository.EventLocaleRepositoryTest;
import br.edu.utfpr.tsi.atividadejpa.repository.ShowRepositoryTest;
import br.edu.utfpr.tsi.atividadejpa.repository.TicketShowRepositoryTest;
import br.edu.utfpr.tsi.atividadejpa.repository.UserRepositoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EventLocaleRepositoryTest.class,
        ShowRepositoryTest.class,
        UserRepositoryTest.class,
        TicketShowRepositoryTest.class
})
public class SuitTest {

}
