using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Projeto_Integrado_A_;

namespace Projeto_Integrado_A_
{
    public partial class Teste : Form
    {

        List<int> Sorteados;
        IEnumerable<Button> BotoesDeNumero;

        public Teste()
        {
            InitializeComponent();
            Sorteados = new List<int>();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {

            Random rand = new Random();

            // Impede de gerar repetidos
            int S;
            do
            {
                S = rand.Next(00, 99);
            } while (Sorteados.Any(n => n == S));

            Sorteados.Add(S);

            // Para de sortear quanto for menor ou igual a 20
            if (Sorteados.Count() >= 20)
                timer1.Stop();

            if (Sorteados.Count() >= 10)
            {
                BUTstop.Enabled = true;
                BUTaposte.Enabled = true;
            }


            // Marca a cor no botão

            foreach (var but in BotoesDeNumero)
            {
                if (int.Parse(but.Text) == S)
                {
                    but.BackColor = Color.Red;
                }
            }

            // Poe no text box
            TXTsortiados.Text = TXTsortiados.Text + S.ToString("00") + " ";

        }

        private void Sorteio_Load(object sender, EventArgs e)
        {
            BotoesDeNumero = this.Controls.OfType<GroupBox>().First().Controls.OfType<Button>();
        }

        private void BUTstar_Click(object sender, EventArgs e)
        {

            timer1.Enabled = true;
        }

        private void BUTstop_Click(object sender, EventArgs e)
        {
            timer1.Enabled = false;
        }

        private void BUTlimpar_Click(object sender, EventArgs e)
        {
            TXTsortiados.Clear();
            Sorteados.Clear();
            BUTstop.Enabled = false;
            BUTaposte.Enabled = false;

            foreach (var btn in BotoesDeNumero)
                btn.BackColor = BUTstop.BackColor;
        }

        private void BUTaposte_Click(object sender, EventArgs e)
        {
            Projeto_Integrado_A_v2.VerificaGravaAposta(TXTsortiados.Text);
            this.Close();
        }


    }
}
