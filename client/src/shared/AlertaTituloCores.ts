const alertaTituloCores: ReadonlyArray<string> = [
                                                    "gainsboro",
                                                    "tan",
                                                    "skyblue",
                                                    "darksalmon",
                                                    "gold"
                                                 ]

export class AlertaTituloCores {

    static getCor(indice: number): string {
        return alertaTituloCores[indice - 1];
    }
}