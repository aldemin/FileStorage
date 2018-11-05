package com.alexandr.demin.filestorage;

import javax.jcr.Repository;
import javax.jcr.Session;

public class Server {

    private Repository repository;
    private Session session;

    private final String url;

    public Server(String url) {
        this.url = url;
    }
/*
    public boolean login(String login, String password) {
        if (status()) return false;
        try {
            repository = new URLRemoteRepository(url);

            final char[] charPassword = password.toCharArray();
            final SimpleCredentials credentials = new SimpleCredentials(login, charPassword);

            session = repository.login(credentials);
            return true;
        } catch (final Exception e) {
            //todo
            return false;
        }
    }

    public boolean logout() {
        if (repository == null) return false;
        if (session == null) return false;
        try {
            session.logout();
            repository = null;
            session = null;
            return true;
        } catch (Exception e) {
            //todo
            return false;
        }
    }

    public Repository getRepository() {
        return repository;
    }

    public Session getSession() {
        return session;
    }

    public boolean status() {
        return repository != null && session != null;
    }

    public boolean save() throws RepositoryException {
        if (!status()) return false;
        session.save();
        return true;
    }

    public Node getRootNode() throws RepositoryException {
        if (!status()) return null;
        return session.getRootNode();
    }*/
}
