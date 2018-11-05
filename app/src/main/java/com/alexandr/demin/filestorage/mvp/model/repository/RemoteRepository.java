package com.alexandr.demin.filestorage.mvp.model.repository;

import com.alexandr.demin.filestorage.Server;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public class RemoteRepository implements FileRepository<Node> {

    private final Server server;

    public RemoteRepository(Server server) {
        this.server = server;
    }

    @Override
    public List<Node> getFoldersList(Node folder) throws RepositoryException {
        return null;
    }

    @Override
    public List<Node> getFilesList(Node folder) throws RepositoryException {
        return null;
    }

    @Override
    public Node getStorage() throws RepositoryException {
        return null;
    }

    @Override
    public void createFile(String name, Node folder) throws RepositoryException {

    }

    @Override
    public void deleteFile(Node file) throws RepositoryException {

    }

    @Override
    public void createFolder(String name, Node folder) throws RepositoryException {

    }

    @Override
    public void deleteFolder(Node folder) throws RepositoryException {

    }

    @Override
    public void writeData(Node file, byte[] data) throws RepositoryException {

    }

    @Override
    public byte[] readData(Node file) {
        return new byte[0];
    }
    /*
    private final String NT_FILE = "nt:file";
    private final String NT_FOLDER = "nt:folder";
    private final String NT_RESOURCE = "nt:resource";
    private final String JCR_CONTENT = "jcr:content";
    private final String JCR_LAST_MODIFIER = "jcr:lastModified";
    private final String JCR_DATA = "jcr:data";

    private final Server server;

    public RemoteRepository(Server server) {
        this.server = server;
    }

    @Override
    public List<Node> getFoldersList(Node folder) throws RepositoryException {
        return getNodeList(folder, NT_FOLDER);
    }

    @Override
    public List<Node> getFilesList(Node folder) throws RepositoryException {
        return getNodeList(folder, NT_FILE);
    }

    private List<Node> getNodeList(Node folder, String type) throws RepositoryException {
        List<Node> nodeList = new ArrayList<>();
        NodeIterator iterator = folder.getNodes();
        while (iterator.hasNext()) {
            Node node = iterator.nextNode();
            if (node.isNodeType(type)) {
                nodeList.add(node);
            }
        }
        return nodeList;
    }

    @Override
    public Node getStorage() throws RepositoryException {
        List<Node> nodeList = new ArrayList<>();
        NodeIterator iterator = server.getRootNode().getNodes();
        while (iterator.hasNext()) {
            Node node = iterator.nextNode();
            nodeList.add(node);
        }
        //return nodeList;
    }

    @Override
    public void createFile(String name, Node folder) throws RepositoryException {
        createNode(name, folder, NT_FILE);
    }

    @Override
    public void createFolder(String name, Node folder) throws RepositoryException {
        createNode(name, folder, NT_FOLDER);
    }

    private void createNode(String name, Node folder, String type) throws RepositoryException {
        Session session = server.getSession();
        if (session == null) {
            return;
        }
        folder.addNode(name, type);
        session.save();
    }

    @Override
    public void deleteFile(Node file) throws RepositoryException {
        deleteNode(file);
    }

    @Override
    public void deleteFolder(Node folder) throws RepositoryException {
        deleteNode(folder);
    }

    private void deleteNode(Node node) throws RepositoryException {
        node.remove();
    }

    @Override
    public void writeData(Node file, byte[] data) throws RepositoryException {

    }

    @Override
    public byte[] readData(Node file) {
        return new byte[0];
    }*/
}
