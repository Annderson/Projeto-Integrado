using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Projeto_Integrado_A_
{
    public partial class Sorteio2 : Form
    {
        public Sorteio2()
        {
            InitializeComponent();
        }
       

        private void BUTstar_Click(object sender, EventArgs e)
        {
            int contador = 0;

            Random rand = new Random();

            while (contador < 10)
            {
                int S = rand.Next(00, 99);

                foreach (var butoes in this.Controls.OfType<Button>())
                {
                    if (butoes.Text == Convert.ToString(S))
                    {
                        butoes.BackColor = Color.Red;
                    }
                }
                TXTsortiados.Text = TXTsortiados.Text + " - " + S;
                
                
                contador++;
            }

        }


        private void Sorteio2_Load(object sender, EventArgs e)
        {
            IEnumerable<Button> butoes;
            butoes = this.Controls.OfType<Button>();
        }

    }
}
