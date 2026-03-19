package br.unipar.frameworks.commands;

import br.unipar.framework.miniframework.CommandHandler;
import br.unipar.framework.miniframework.Request;
import br.unipar.framework.miniframework.Response;

public class ConvertCommand implements CommandHandler {
    @Override
    public Response handle(Request request) {
        if (request.getArgs().isEmpty()) {
            return  Response.badRequest("Uso: horas <horas>");
        }

        try {

            double horas = Double.parseDouble(request.getArgs().get(0));
            double dias = horas / 24;

            return  Response.ok(horas + " horas = " + dias + " dias");

        } catch (NumberFormatException e) {
            return  Response.badRequest("Erro: digite apenas números.");
        }

    }
}
