package business.control.command;

import business.control.Facade;

import java.util.List;

public class DelNewsCommand extends CommandWithResult<List<String>>{
    private final Facade facade;
    private final String titulo;

    public DelNewsCommand(Facade facade, String titulo){
        this.facade = facade;
        this.titulo = titulo;
    }

    @Override
    public void execute() {
        result = facade.deletePost(this.titulo);
    }
}
