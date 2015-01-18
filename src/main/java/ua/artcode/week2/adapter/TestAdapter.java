package ua.artcode.week2.adapter;

public class TestAdapter {
    public static void main(String[] args) {
        Worker worker = new Worker();
        WorkerAdapter workerAdapter = new WorkerAdapter(worker);

        Company company = new Company();
        company.doMoney(workerAdapter);

    }

}

class Worker {
    void work(){
        System.out.println("old worker");
    }
}

class ModernWorker {
    void modernWork(){
        System.out.println("modern worker");
    }
}

class Company {
    void doMoney(ModernWorker modernWorker){
        modernWorker.modernWork();
    }
}

class WorkerAdapter extends ModernWorker{
    Worker worker;

    WorkerAdapter(Worker worker) {
        this.worker = worker;
    }

    @Override
    void modernWork() {
        worker.work();
    }
}