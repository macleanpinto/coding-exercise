export interface TodoItem {
  id: number;
  description: string;
  completed: boolean;
}

export class TodoItem11 {

  private ALPHABET = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
  private uuid: string;
  private description: string;
  private completed: boolean;

  public setuuid(uuid: string) {
    this.uuid = uuid;
  }
  public getuuid() {
    return this.uuid;
  }
  public setDescription(description: string) {
    this.description = description;
  }
  public getDescription() {
    return this.description;
  }
  public setCompleted(completed: boolean) {
    this.completed = completed;
  }
  public getCompleted() {
    return this.completed;
  }



  generate() {
    let rtn = '';
    for (let i = 0; i < 8; i++) {
      rtn += this.ALPHABET.charAt(Math.floor(Math.random() * this.ALPHABET.length));
    }
    return rtn;
  }

  constructor(data: any) {
    this.uuid = this.generate();
    this.completed = data.completed;
    this.description = data.description;
    console.log(this.uuid);
  }
}
