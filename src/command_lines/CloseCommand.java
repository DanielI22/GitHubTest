package command_lines;

import bg.tu_varna.sit.StudentServiceSystem;
import exceptions.FileNotOpenedException;

public class CloseCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException {
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        StudentServiceSystem.setSystemInstance(null);
        OpenCommand.openedFile=false;
        System.out.println("Successfully closed " + OpenCommand.fileName);
    }
}
