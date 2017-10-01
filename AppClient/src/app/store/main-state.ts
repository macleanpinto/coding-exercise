export interface State {
    uuid: string;
    description: string;
    completed: boolean;
}

export const intitialState: State = {
    uuid: '',
    description: 'Task1',
    completed: false,
};

