import org.junit.jupiter.api.Test;

import com.uendel.User;
import com.uendel.WorkLog;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class WorkLogTest {

    @Test
    void deveCriarWorkLogValido() {
        User user = new User("João", "joao@empresa.com", "Dev");
        WorkLog log = new WorkLog(user, 2.5, LocalDate.now(), "Implementação de tela");

        assertNotNull(log.getId());
        assertEquals(2.5, log.getHoras());
        assertEquals("Implementação de tela", log.getDescricao());
    }

    @Test
    void deveLancarExcecaoParaHorasNegativas() {
        User user = new User("Maria", "maria@empresa.com", "QA");
        assertThrows(IllegalArgumentException.class, () ->
            new WorkLog(user, -1.0, LocalDate.now(), "Bugfix")
        );
    }

    @Test
    void deveManterObjetoOriginalInalterado() {
        User user = new User("Ana", "ana@empresa.com", "Scrum Master");
        WorkLog original = new WorkLog(user, 3.0, LocalDate.now(), "Planejamento da sprint");
        WorkLog atualizado = original.atualizarHoras(5.0);

        assertEquals(3.0, original.getHoras()); // original permanece igual
        assertEquals(5.0, atualizado.getHoras()); // novo objeto reflete a alteração
        assertNotEquals(original.getId(), atualizado.getId()); // IDs são diferentes
    }
}

