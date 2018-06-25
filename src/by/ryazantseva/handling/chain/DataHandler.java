package by.ryazantseva.handling.chain;

import by.ryazantseva.handling.composite.impl.TextComposite;
import by.ryazantseva.handling.exception.InvalidInputDataException;


public interface DataHandler {
    TextComposite handleRequest(String  string) throws InvalidInputDataException;
}
