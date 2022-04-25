package command_lines;

public class HelpCommand implements Command{
    @Override
    public void execute(Object[] args) {
            printAll();
    }


    private void printAll(){
        System.out.println(
                "The following main commands are supported:\n" +
                    "open <file>   opens <file>\n"+
                    "close         closes currently opened file \n" +
                    "save          saves the currently open file \n" +
                    "saveas <file> saves the currently open file in <file> \n" +
                    "help          prints this information \n" +
                    "exit          exists the program  \n\n" +
                "The following student specific commands are supported:\n" +
                    "enroll <fn> <program> <group> <name>   enrolls a student with name <name> in year 1 of program <program> in group <group> with faculty number <fn>\n"+
                    "advance <fn>                           enrolls a student in the next year \n" +
                    "change <fn> <option> <value>           changes student's <program OR group OR year> to <value> \n" +
                    "graduate <fn>                          marks a student as GRADUATED \n" +
                    "interrupt <fn>                         marks a student as INACTIVE \n" +
                    "resume <fn>                            marks a student as ACTIVE \n" +
                    "print <fn>                             prints information about a student\n" +
                    "printall <program> <year>              prints information about all students in <year> of <program> \n" +
                    "enrollin <fn> <course>                 enrolls a student in <course>\n" +
                    "addgrade <fn> <course> <grade>         adds <grade> in <course> to a student \n" +
                    "protocol <course>                      prints protocol for all students in <course> \n" +
                    "report <fn>                            prints full report of a student ");
    }
}
