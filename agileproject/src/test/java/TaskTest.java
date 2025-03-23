import org.junit.jupiter.api.Test;

import com.uendel.Task;
import com.uendel.User;
import com.uendel.WorkLog;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void deveCriarTarefaValida() {
        User user = new User("Uendel", "uendel@empresa.com", "Desenvolvedor");
        Task task = new Task("Criar login", "Implementar endpoint de autenticação", Task.Status.TODO, user);

        assertEquals("Criar login", task.getTitulo());
        assertEquals(Task.Status.TODO, task.getStatus());
        assertEquals(user, task.getResponsavel());
    }

    @Test
    void deveAlterarStatusImutavelmente() {
        User user = new User("Ana", "ana@empresa.com", "Backend");
        Task taskOriginal = new Task("Criar API", "Desenvolver API REST", Task.Status.TODO, user);

        Task taskAtualizada = taskOriginal.alterarStatus(Task.Status.IN_PROGRESS);

        assertEquals(Task.Status.TODO, taskOriginal.getStatus());
        assertEquals(Task.Status.IN_PROGRESS, taskAtualizada.getStatus());
        assertNotSame(taskOriginal, taskAtualizada);
    }

    @Test
    void deveAtribuirNovoResponsavelImutavelmente() {
        User antigo = new User("Lucas", "lucas@empresa.com", "DevOps");
        User novo = new User("Larissa", "larissa@empresa.com", "Analista QA");

        Task taskOriginal = new Task("Configurar CI", "Pipeline de build", Task.Status.TODO, antigo);
        Task taskAtualizada = taskOriginal.atribuirResponsavel(novo);

        assertEquals(antigo, taskOriginal.getResponsavel());
        assertEquals(novo, taskAtualizada.getResponsavel());
    }

    @Test
    void deveAdicionarWorkLogSemAlterarObjetoOriginal() {
        User user = new User("Pedro", "pedro@empresa.com", "Dev");
        Task task = new Task("Documentar código", "Criar Javadoc", Task.Status.TODO, user);

        WorkLog log = new WorkLog(user, 3.5, LocalDate.now(), "Documentação da camada de serviço");

        Task taskComLog = task.adicionarWorkLog(log);

        assertTrue(task.getRegistrosTrabalho().isEmpty()); // original não alterado
        assertEquals(1, taskComLog.getRegistrosTrabalho().size()); // nova instância com o log
        assertEquals(log, taskComLog.getRegistrosTrabalho().get(0));
    }
}
