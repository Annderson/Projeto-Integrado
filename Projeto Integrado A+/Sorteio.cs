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
    public partial class Sorteio : Form
    {

        List<int> Sorteados;
        IEnumerable<Button> BotoesDeNumero;

        public Sorteio()
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

            if (Sorteados.Count() >= 10)
                BUTstop.BackColor = Color.Green;
            else
                BUTstop.BackColor = Color.Red;

            // Para de sortear quando tem 20
            if (Sorteados.Count() >= 20)
            {
                BUTstop.PerformClick();
            }

            // Marca a cor no botão

            foreach (var but in BotoesDeNumero)
            {
                if (int.Parse(but.Text) == S)
                {
                    but.BackColor = Color.Green;
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
            if (Sorteados.Count >= 20)
                BUTlimp.PerformClick();

            BUTapost.Enabled = false;
            timer1.Start();
        }

        private void BUTstop_Click(object sender, EventArgs e)
        {
            timer1.Stop();
            
            if (Sorteados.Count >= 10)
                BUTapost.Enabled = true;
        }

        private void BUTapost_Click(object sender, EventArgs e)
        {
            Projeto_Integrado_A_v2.VerificaGravaAposta(TXTsortiados.Text);
            this.Close();
        }

        private void BUTlimp_Click(object sender, EventArgs e)
        {
            TXTsortiados.Clear();
            Sorteados.Clear();
            BUTapost.Enabled = false;
            BUTstop.BackColor = BUTstar.BackColor;

            foreach (var btn in BotoesDeNumero)
                btn.BackColor = BUTstar.BackColor;
        }

        private void BUTaposte_Click(object sender, EventArgs e)
        {
            Projeto_Integrado_A_v2.VerificaGravaAposta(TXTsortiados.Text);
            this.Close();
        }


    }
}
