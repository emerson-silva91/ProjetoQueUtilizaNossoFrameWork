package br.unipar.frameworks.commands;

import br.unipar.framework.miniframework.CommandHandler;
import br.unipar.framework.miniframework.Request;
import br.unipar.framework.miniframework.Response;

public class PercentCommand implements CommandHandler {


    @Override
    public Response handle(Request request) {

        if (request.getArgs().size() < 2) {
            return  Response.badRequest("Uso: porcentagem <valor> <porcentagem>");
        }

        try {

            double valor = Double.parseDouble(request.getArgs().get(0));
            double porcentagem = Double.parseDouble(request.getArgs().get(1));

            double resultado = (valor * porcentagem) / 100;

            return  Response.ok(porcentagem + "% de " + valor + " = " + resultado);

        } catch (NumberFormatException e) {
            return  Response.badRequest("Erro: digite apenas números.");
        }
    }
}
